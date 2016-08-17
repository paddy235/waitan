package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.util.relation.Utils;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wangchenge
 * @since 2016.08.16
 */
public class SuperController {
    @Autowired(required = true)
    private HttpServletRequest request;
    private HttpServletResponse response;


    public ModelAndView writeModelAndView(String view, int page, int pageCount) {
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageCount", pageCount);
        return modelAndView;
    }

    /**
     * 返回json，页面通过msg来接收
     *
     * @param msg
     */
    public void writeMsgJson(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", msg);
        sendJson(jsonObject.toString());
    }

    /**
     * 直接返回map<key，value>
     *
     * @param map
     */
    public void writeJSONMap(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jsonObject = new JSONObject();
            Set<String> set = map.keySet();
            for (String key : set) {
                String value = map.get(key);
                jsonObject.put(key, Utils.trimAndRowStr(value));
            }
            sendJson(jsonObject.toString());
        } else {
            sendJson("");
        }
    }

    /**
     * 直接返回Object实体对象
     *
     * @param object
     */
    public void writeObjectJson(Object object) {
        if (object != null) {
            sendJson(new Gson().toJson(object));
        } else {
            renderText("");
        }
    }

    @SuppressWarnings("rawtypes")
    public void writeListJson(List list) {
        try {
            sendJson(JSONArray.fromObject(list).toString());
        } catch (Exception e) {
            sendJson(e.getMessage());
        }
    }

    @SuppressWarnings("rawtypes")
    public String changeListJson(List list) {
        String json = "";
        try {
            json = JSONArray.fromObject(list).toString();
        } catch (Exception e) {
            sendJson(e.getMessage());
        }
        return json;
    }

    @SuppressWarnings("rawtypes")
    public void writeListAndRowsJson(List list, int total) {
        try {
            if (list != null && list.size() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("total", String.valueOf(total));
                jsonObject.put("rows", new Gson().toJson(list));
                sendJson(jsonObject.toString());
            } else {
                renderText("");
            }
        } catch (Exception e) {
            sendJson(e.getMessage());
        }
    }


    public void sendJson(String text) {
        if (!Utils.isNullForString(text)) {
            text = text.replaceAll("\\$cglib_prop_", "");
        }
        send(text, "text/html;charset=UTF-8");
        System.out.println(text);
    }

    protected void send(String text, String contentType) {
        try {
            response.setContentType(contentType);
            response.getWriter().write(text);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeMsg(String msg) {
        this.getRequest().setAttribute("msg", msg);
    }

    public void writeMsg(String msg, String lastUrl) {
        this.getRequest().setAttribute("msg", msg);
    }

    /**
     * 获取字符串类型的参数
     *
     * @param param 参数名称
     * @param def   默认
     * @throws UnsupportedEncodingException
     * @return 字符串
     */
    public String getStr(HttpServletRequest request, String param, String def) {
        String value = request.getParameter(param);
        if (value == null || value.isEmpty()) {
            return def;
        } else {
            try {
                value = new String(value.getBytes(), Constants.characterCode);
                value = URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        return value;
    }

    protected void renderText(String text) {
        send(text, "text/plain;charset=UTF-8");
    }

    protected void renderHtml(String text) {
        send(text, "text/html;charset=UTF-8");
    }

    protected void renderXML(String text) {
        send(text, "text/xml;charset=UTF-8");
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected HttpSession getSession() {
        return request.getSession();
    }

    @ModelAttribute
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
