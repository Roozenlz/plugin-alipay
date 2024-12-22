package run.halo.starter;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import run.halo.app.core.extension.endpoint.CustomEndpoint;
import run.halo.app.extension.GroupVersion;
import run.halo.app.extension.ListResult;

/**
 * @author <a href="https://roozen.top">Roozen</a>
 * @version 1.0
 * 2024/12/22
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyEndPoint implements CustomEndpoint {

    @Override
    public RouterFunction<ServerResponse> endpoint() {
        return SpringdocRouteBuilder.route()
            .GET("qrcode", this::getQRCode, builder -> {
                    builder.operationId("qrcode")
                        .tag("api.store.kunkunyu.com/v1alpha1/qrcode")
                        .response(
                            responseBuilder()
                                .implementation(ListResult.generateGenericClass(String.class))
                        );
                }
            ).build();
    }

    Mono<ServerResponse> getQRCode(ServerRequest serverRequest) {
        // try {
        //     // 2. 发起API调用（以创建当面付收款二维码为例）
        //     AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
        //         .preCreate("Apple iPhone11 128G", "2234567890", "5799.00");
        //     // 3. 处理响应或异常
        //     if (ResponseChecker.success(response)) {
        //         System.out.println("调用成功");
        //         System.out.println(response);
        //         System.out.println("qrCode:");
        //         System.out.println(response.qrCode);
        //     } else {
        //         System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
        //     }
        // } catch (Exception e) {
        //     System.err.println("调用遭遇异常，原因：" + e.getMessage());
        //     throw new RuntimeException(e.getMessage(), e);
        // }
        return null;
    }

    @Override
    public GroupVersion groupVersion() {
        return GroupVersion.parseAPIVersion("api.store.kunkunyu.com/v1alpha1");
    }
}
