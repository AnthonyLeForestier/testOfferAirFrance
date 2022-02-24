package offer.test.airfrance.config;

import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import offer.test.airfrance.controller.UserController;

@Configuration
public class OpenApiConfig {

	@Value("${build.version}")
	private String buildVersion;

	@Bean
	public OpenAPI confiOpenApi() {
		return new OpenAPI().info(new Info().title("Swagger test offer")
				.description("User repository management application").version(buildVersion));
	}

	@Bean
	public GroupedOpenApi internalApi() {
		return GroupedOpenApi.builder().group("swagger").packagesToScan(UserController.class.getPackageName())
				.addOpenApiCustomiser(sort()).build();
	}

	@Bean
	public OpenApiCustomiser sort() {
		return openApi -> openApi.setTags(
				openApi.getTags().stream().sorted(Comparator.comparing(tag -> StringUtils.strip(((Tag) tag).getName())))
						.collect(Collectors.toList()));
	}

}
