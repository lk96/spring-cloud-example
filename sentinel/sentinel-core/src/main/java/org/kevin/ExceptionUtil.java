package org.kevin;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpRequestExecution;

import java.net.http.HttpRequest;

@Slf4j
public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static SentinelClientHttpResponse handleException(HttpRequest request, byte[] body
            , ClientHttpRequestExecution execution, BlockException exception) {
        log.error("Oops: "+exception.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("custom block info");
    }
}
