package run.halo.starter;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import run.halo.app.core.extension.content.Constant;
import run.halo.app.extension.AbstractExtension;
import run.halo.app.extension.GVK;

/**
 * @author <a href="https://roozen.top">Roozen</a>
 * @version 1.0
 * 2024/12/23
 */
@Data
@ToString(callSuper = true)
@GVK(kind = "test", group = "store.kunkunyu.com",
    version = Constant.VERSION, singular = "test", plural = "tests")
@EqualsAndHashCode(callSuper = true)
public class Test  extends AbstractExtension {
    private String test;

    @Schema(requiredMode = REQUIRED)
    private TestSpec spec;

    @Data
    public static class TestSpec {
        @Schema(requiredMode = REQUIRED, minLength = 1)
        private String test;
    }
}
