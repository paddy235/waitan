package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.recruit.StringUtil;
import com.bbd.wtyh.domain.vo.LevelSortVO;
import com.bbd.wtyh.domain.vo.OrderPO;
import com.bbd.wtyh.service.CommonService;
import com.bbd.wtyh.service.OrderService;
import com.bbd.wtyh.util.recruit.AESUtils;
import com.bbd.wtyh.util.recruit.ASC2;
import com.bbd.wtyh.util.recruit.SystemUtils;
import com.bbd.wtyh.util.relation.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * @author wangchenge
 * @since 2016.08.16
 */
public class BaseSuperController extends SuperController  {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommonService commonService;

//    @Autowired
//    private SessionLocaleResolver sessionLocaleResolver;

//    protected Locale getLocale(HttpServletRequest request) {
//        return sessionLocaleResolver.resolveLocale(request);
//    }

    /**
     * 对公司名字字符串加密
     *
     * @param companyName
     * @return
     */

    protected String encryptCompanyName(String companyName) {
        String encrypt = AESUtils.encrypt(companyName + Utils.getRanod(), Constants.systemAesScret);
        if (!Utils.isNullForString(encrypt)) {
            return ASC2.string2Hex(encrypt);
        } else {
            return null;
        }
    }

    /**
     * 对公司名字字符串解密
     *
     * @param companyName
     * @return
     */

    protected String decryptCompanyName(String companyName) {
        if (!Utils.isNullForString(companyName)) {
            String string = ASC2.hex2String(companyName);
            String comapnyAndRanod = AESUtils.decrypt(string, Constants.systemAesScret);
            int len = comapnyAndRanod.length();
            return comapnyAndRanod.substring(0, len - 6);
        } else {
            return null;
        }
    }


    /**
     * 设置工商注册资料左侧菜单
     */
    public void setLeveMenu() {
        HttpServletRequest request = super.getRequest();
        String companyName = request.getParameter("companyName");
        String mid = request.getParameter("mid");
        HttpSession session = request.getSession();
        String currentUser = (String) session.getAttribute(Constants.SESSION.showLoginName);
        //获得用户权限菜单
        String level = commonService.powerSet(currentUser, this.decryptCompanyName(companyName));
        List<LevelSortVO> levelList = SystemUtils.levelMap.get(level);
        request.setAttribute("levelList", levelList);
        request.setAttribute("mid", mid);
    }

    /**
     * 设置工商注册资料左侧菜单
     */
    public void setLeveMenu(boolean flag) {
        HttpServletRequest request = super.getRequest();
        String companyName = request.getParameter("companyName");
        String mid = request.getParameter("mid");
        HttpSession session = request.getSession();
        String currentUser = (String) session.getAttribute(Constants.SESSION.showLoginName);
        //获得用户权限菜单
        String level = commonService.powerSet(currentUser, companyName);
        List<LevelSortVO> levelList = SystemUtils.levelMap.get(level);
        request.setAttribute("levelList", levelList);
        request.setAttribute("mid", mid);
    }

    /**
     * 设置管理中心左侧菜单
     */
    public void setAgentLeveMenu() {
        HttpServletRequest request = super.getRequest();
        String amid = request.getParameter("amid");
        request.setAttribute("amid", amid);
    }

    /**
     * 设置订单参数
     *
     * @param mv
     * @param companyName
     * @param username
     */
    protected void setOrderParam(ModelAndView mv, String companyName, String username) {
        if (StringUtil.isNotNullOrEmpty(companyName) && StringUtil.isNotNullOrEmpty(username)) {
            // 查询订单信息
            OrderPO po = orderService.queryOrder(companyName, username);
            mv.addObject("level", po.getLevel());
            mv.addObject("signMark", po.getSignMark());
            mv.addObject("deadlines", po.getDeadlines());
        }
    }
}
