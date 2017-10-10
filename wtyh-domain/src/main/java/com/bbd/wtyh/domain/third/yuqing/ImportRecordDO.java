package com.bbd.wtyh.domain.third.yuqing;

import com.alibaba.fastjson.annotation.JSONField;
import com.bbd.wtyh.domain.BaseDO;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.excel.imp.utils.FileUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * 第三方舆情导入记录
 * 
 * @author Created by LiYao on 2017-10-09 9:19.
 */
@Entity
@Table(name = "third_yuqing_imp_record")
public class ImportRecordDO extends BaseDO {

    private static final long serialVersionUID = -7230264582880767788L;
    /** ID */
    @Id
    @Column(name = "id")
    private Integer id;

    /** 名称 */
    @Column(name = "file_name")
    private String fileName;

    /** 文件大小（byte） */
    @Column(name = "file_size")
    private Long fileSize;

    /** 舆情时间 */
    @Column(name = "yuqing_time")
    @JsonFormat(pattern = "YYYY-MM-dd", timezone = "GMT+8")
    @JSONField(format = "YYYY-MM-dd")
    private Date yuqingTime;

    @Column(name = "imp_state")
    private Integer impState;
    @Column
    private Integer source;
    @Column
    private String remark;

    public String getImpStateDesc() {
        return ImpRecord.getRecord(this.getImpState()).desc();
    }

    public String getFileSizeDesc() {
        double fileSize = this.getFileSize();
        return FileUtil.fileSizeDesc(fileSize);
    }

    /**
     * 获取 ID
     *
     * @return id ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 名称
     *
     * @return fileName 名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 名称
     *
     * @param fileName 名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取 文件大小（byte）
     *
     * @return fileSize 文件大小（byte）
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 设置 文件大小（byte）
     *
     * @param fileSize 文件大小（byte）
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取 舆情时间
     *
     * @return yuqingTime 舆情时间
     */
    public Date getYuqingTime() {
        return yuqingTime;
    }

    /**
     * 设置 舆情时间
     *
     * @param yuqingTime 舆情时间
     */
    public void setYuqingTime(Date yuqingTime) {
        this.yuqingTime = yuqingTime;
    }

    public Integer getImpState() {
        return impState;
    }

    public void setImpState(Integer impState) {
        this.impState = impState;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}