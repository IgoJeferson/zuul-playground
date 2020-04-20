package com.mercadao.apigateway.filter;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class LogResponseFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(LogResponseFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try (final InputStream responseDataStream = ctx.getResponseDataStream())
        {
            final String responseData =
                    CharStreams.toString(new InputStreamReader(responseDataStream,
                            "UTF-8"));

            logger.info(String.format("response data %s", responseData));
            ctx.setResponseBody(responseData);
        } catch (IOException e) {
            logger.error("Error reading body", e);
            try {
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
