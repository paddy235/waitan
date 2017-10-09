package com.bbd.bgo.service.task;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public interface CompanyTagService {

    /**
     * 对外提供的调用接口
     *
     * @throws Exception
     */
    void addTagAndCompany();

    /**
     * 保存企业tag
     *
     * @throws Exception
     */
    void saveCompanyTag();

    /**
     * 新增company表中没有，但qyxx_tag中有的企业
     * 新增条件：必须包含一个外滩线下理财企业的标签
     *
     * @throws Exception
     */
    void addCompanyFromQyxxTag();

    /**
     * 更新company中的company_type
     * 更新条件：company中原本就是线下理财类型或者是空，qyxx_tag中该企业只有一种标签（非外滩线下理财企业）
     *
     * @throws Exception
     */
    void updateCompanyTypeFromQyxxTag();

    /**
     * 更新company中的company_type
     * 更新条件：company中类型是空，qyxx_tag中包含该企业的一个线下理财标签
     *
     * @throws Exception
     */
    void updateTypeWhenTypeIsNullAndHaveOffLine();


}
