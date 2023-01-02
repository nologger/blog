package kim.blog.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "잘못된 접근입니다.")
public class UrlNotFoundException extends RuntimeException{
}
