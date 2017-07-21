<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="libs/js/jquery-1.11.2.js"></script>
<script type="text/javascript">

    var int;

    $(document).ready(function () {
        var $download_error_btn = $('#download-error'),
            $download_template_btn = $('#download-template');
        $download_error_btn.attr('disabled', 'disabled');


        $('#upload').click(function () {
            var form = document.getElementById("upload-form");
            var formData = new FormData(form);

            $.ajax({
                url: '/import/import-data.do?impType=2',
                type: 'POST',
                data: formData,
                processData: false,
                // 告诉jQuery不要去设置Content-Type请求头
                contentType: false,
                success: function () {
                    int = window.setInterval("progress()", 1000);
                }
            });
        });

        $download_error_btn.click(function () {
            var array = $('#file').val().split("\\"),
                fileName = array[array.length - 1];
            window.location.href = '/import/download-error-file.do?fileName=' + fileName;

        });
        $download_template_btn.click(function () {
            var name = $('#templateName').val();
            window.location.href = '/import/import-template.do?templateName=' + name;

        });

    });

    function progress() {
        var $progress_dev = $('#progress-dev'),
            array = $('#file').val().split("\\"),
            fileName = array[array.length - 1];
        $('#download-error').attr('disabled', 'disabled');
        $.ajax({
            url: "/import/import-progress.do",
            data: {
                fileName: fileName
            },
            dataType: 'json',
            success: function (data) {
                if (data === null) {
                    return;
                }
                if (!data.success || data.content === '') {
                    window.clearInterval(int);
                    return;
                }
                var isFinish = false,
                    content = data.content;

                $progress_dev.html('<h1>导入信息</h1>');

                $.each(content, function (key, value) {
                    $progress_dev.append('<h3>Sheet：' + value.sheetName + '</h3>');
                    $progress_dev.append('<h3>总行数：' + value.totalRowNum + '</h3>');
                    $progress_dev.append('<h3>已处理：' + value.processed + '，错误数：' + value.errorRowNum + '</h3>');
                    $progress_dev.append('<h3>进度：' + value.progress + '</h3>');
                    $progress_dev.append('<hr>');

                    if (value.errorList.length > 0) {
                        $('#download-error').removeAttr('disabled');
                    }

                    isFinish = value.finish;
                });

                if (isFinish) {
                    window.clearInterval(int)
                }
            },
            error: function () {
                window.clearInterval(int)
            }
        });

    }

</script>
<head>
    <form id="upload-form" enctype="multipart/form-data">
        <h1>上传EXCEL</h1>
        模版名称：<input type="text" id="templateName" name="templateName" value="Test">
        <input type="file" id="file" name="file">
        <input type="button" id="download-template" value="下载导入模版"/>
        <input type="button" id="upload" value="上传数据文件"/>
        <input type="button" id="download-error" value="下载错误文件" disabled="disabled"/>
    </form>

    <div id="progress-dev" style="width: 800px;height:500px;border: 1px solid black ;padding-left: 10px;">
        <h1 id="sheetName">导入信息</h1>
    </div>

</head>
<body>

</body>
</html>
