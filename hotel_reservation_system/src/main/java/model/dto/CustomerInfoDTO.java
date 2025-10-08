package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerInfoDTO {

    private String id;
    private String name;
    private int age;
    private String phoneNo;
    private String city;

}
