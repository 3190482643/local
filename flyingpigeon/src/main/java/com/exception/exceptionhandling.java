package com.exception;
import com.domain.result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class exceptionhandling {
    @ExceptionHandler(Exception.class)
    public result returnexceptionclass(Exception e) throws IOException {
        String Class = e.getClass().toString();
        File f = new File("src\\main\\java\\com\\exception\\exception-log.txt");
        FileWriter fileWriter = new FileWriter(f, true);
        fileWriter.write(LocalDateTime.now() +"--异常类名:"+Class+"\n");
        fileWriter.flush();
        fileWriter.close();
        return new result(false);
    }
}
