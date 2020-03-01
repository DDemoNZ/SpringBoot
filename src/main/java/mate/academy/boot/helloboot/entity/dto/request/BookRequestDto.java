package mate.academy.boot.helloboot.entity.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Data
public class BookRequestDto {

    @NotEmpty(message = "Title mustn't not be empty.")
    private String title;
    @NotEmpty(message = "Description mustn't not be empty.")
    private String description;
    @NonNull
    @Min(value = 0, message = "Price can't be negative.")
    private Double price;
    @NonNull
    @Min(value = 0, message = "Year can't be negative.")
    private Integer year;
}
