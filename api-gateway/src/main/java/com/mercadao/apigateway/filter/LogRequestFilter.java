package com.mercadao.apigateway.filter;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogRequestFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(LogRequestFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String requestData = null;
        try {
            if (request.getContentLength() > 0) {
                requestData = CharStreams.toString(request.getReader());
            }
        } catch (Exception e) {
            log.error("Error parsing request", e);
            try {
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        log.info(String.format("%s request to %s, %s", request.getMethod(), request.getRequestURL().toString(), requestData));
        return null;

    }
}
