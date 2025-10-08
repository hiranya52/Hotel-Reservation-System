package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StaffInfoDTO {

    private String id;
    private String name;
    private String role;
    private String email;
    private String phoneNo;
    private double salary;

}
