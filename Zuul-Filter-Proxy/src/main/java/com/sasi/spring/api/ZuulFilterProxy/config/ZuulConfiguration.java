package com.sasi.spring.api.ZuulFilterProxy.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.sasi.spring.api.ZuulFilterProxy.filter.ErrorFilter;
import com.sasi.spring.api.ZuulFilterProxy.filter.PostFilter;
import com.sasi.spring.api.ZuulFilterProxy.filter.PreFilter;
import com.sasi.spring.api.ZuulFilterProxy.filter.RouteFilter;
import com.sasi.spring.api.ZuulFilterProxy.utils.Constants;


@Configuration
public class ZuulConfiguration {
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {
		return new ZuulFallbackProvider() {

			@Override
			public String getRoute() {
				return null;
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				return new ClientHttpResponse() {

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream(Constants.FALLBACK.getBytes());
					}

					@Override
					public String getStatusText() throws IOException {
						return Constants.OK;
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return Constants._200;
					}

					@Override
					public void close() {

					}
				};
			}
		};
	}

}
