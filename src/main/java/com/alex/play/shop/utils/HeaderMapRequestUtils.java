package com.alex.play.shop.utils;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author 颜炼
 * @DATE 2023/3/28 11:12
 * @Description
 * ServletRequestWrapper是Java Servlet API提供的一个包装器类，用于包装HttpServletRequest对象。它的作用是在HttpServletRequest对象的基础上提供额外的功能或修改请求的行为，同时保持与原始请求对象的兼容性。
 *
 * 具体而言，ServletRequestWrapper允许你在HttpServletRequest对象的各个方法上进行定制化的修改。你可以继承ServletRequestWrapper类并重写感兴趣的方法，以实现自定义逻辑。
 *
 * 以下是ServletRequestWrapper的一些常见用途和作用：
 *
 * 修改请求参数：你可以重写getParameter()、getParameterValues()等方法，以修改或增加请求参数的值。这对于请求参数的预处理或过滤非法参数很有用。
 *
 * 修改请求头：你可以重写getHeader()、getHeaders()等方法，以修改请求头信息。这对于添加、删除或修改请求头的值非常有用。
 *
 * 修改请求方法：你可以重写getMethod()方法，以返回不同的请求方法。例如，你可以将POST请求转换为GET请求，或者根据特定条件修改请求方法。
 *
 * 修改请求路径：你可以重写getRequestURI()、getContextPath()等方法，以修改请求的URI或上下文路径。这对于URL重写或路由转发非常有用。
 *
 * 修改请求体：你可以重写getInputStream()、getReader()等方法，以修改请求体的内容。这对于请求体的加密、解密或修改非常有用。
 *
 * 通过继承ServletRequestWrapper类并重写感兴趣的方法，你可以在不修改原始HttpServletRequest对象的情况下，对请求的各个方面进行定制化的修改。这样可以实现请求的个性化处理，并保持与原始请求对象的兼容性，以便后续的处理组件可以正常使用这个包装后的请求对象。
 **/
@Slf4j
public class HeaderMapRequestUtils extends HttpServletRequestWrapper {

    public HeaderMapRequestUtils(HttpServletRequest request) {
        super(request);
    }

    private Map<String, String> headerMap = new HashMap<>();

    public void addHeader(String name, String value) {
        headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        if (headerMap.containsKey(name)) {
            headerValue = headerMap.get(name);
        }
        return headerValue;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        for (String name : headerMap.keySet()) {
            names.add(name);
        }
        return Collections.enumeration(names);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> values = Collections.list(super.getHeaders(name));
        if (headerMap.containsKey(name)) {
            values = Arrays.asList(headerMap.get(name));
        }
        return Collections.enumeration(values);
    }
}

