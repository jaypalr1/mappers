package com.jay;

import com.jay.dto.ExcelToJava;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@Slf4j
@SpringBootApplication
public class Main {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(Main.class, args);

    PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
        .addListDelimiter(";") //By default the delimiter/separator is ";"
//        .sheetIndex(1) //
//        .preferNullOverDefault(true) // If you want a field to return null rather than a default
        .build();

//    List<ExcelToJava> employees1 =
//        Poiji.fromExcel(new File("employees.xlsx"), ExcelToJava.class, options);

    //OR
    InputStream stream = new ClassPathResource("employees.xlsx").getInputStream();
    List<ExcelToJava> employees =
        Poiji.fromExcel(stream, PoijiExcelType.XLSX, ExcelToJava.class, options);

    employees.forEach(System.out::println);
  }
}
