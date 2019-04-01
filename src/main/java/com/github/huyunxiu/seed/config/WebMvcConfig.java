package com.github.huyunxiu.seed.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.huyunxiu.seed.core.Result;
import com.github.huyunxiu.seed.core.ResultCode;
import com.github.huyunxiu.seed.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * WebMvc配置
 *
 * @author huyunxiu01@gmail.com
 * @since 2019-03-30
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
			.addResourceLocations("/");
		registry.addResourceHandler("swagger-ui.htm")
			.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add((request, response, handler, e) -> {
			Result result = new Result();
			result.setCode(ResultCode.FAIL.getCode());

			HandlerMethod handlerMethod = (HandlerMethod) handler;

			if (e instanceof ServiceException) {
				result
					.setCode(((ServiceException) e).getErrorCode())
					.setMsg(e.getMessage());
			} else if (e instanceof NoHandlerFoundException) {
				result
					.setCode(ResultCode.FAIL.getCode())
					.setMsg("接口[" + request.getRequestURI() + "]不存在");
			} else if (e instanceof ServletException) {
				result.setCode(ResultCode.FAIL.getCode()).setMsg(e.getMessage());
			} else if (e instanceof MethodArgumentNotValidException) {
				List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
				String errMsg = String.format("字段%s%s", fieldErrors.get(0).getField(), fieldErrors.get(0).getDefaultMessage());
				result.setCode(ResultCode.FAIL.getCode()).setMsg(errMsg);
			} else {
				result
					.setCode(ResultCode.FAIL.getCode())
					.setMsg("接口[" + request.getRequestURI() + "]内部错误");

				String message;

				if (handler != null) {
					message = String.format("接口 [%s] 内部错误，Method：%s.%s，Message：%s",
						request.getRequestURI(),
						handlerMethod.getBean().getClass().getName(),
						handlerMethod.getMethod().getName(),
						e.getMessage());
				} else {
					message = e.getMessage();
				}

				log.error(message, e);
			}

			responseResult(response, result);

			return new ModelAndView();
		});
	}

	private void responseResult(HttpServletResponse response, Result result) {
		ObjectMapper mapper = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setStatus(200);
		try {
			response.getWriter().write(mapper.writeValueAsString(result));
		} catch (IOException ex) {
			log.error(ex.getMessage());
		}
	}
}
