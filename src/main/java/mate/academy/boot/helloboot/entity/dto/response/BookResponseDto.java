package mate.academy.boot.helloboot.entity.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer year;
}
