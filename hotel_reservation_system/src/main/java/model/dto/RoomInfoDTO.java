package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomInfoDTO {

    private String id;
    private String type;
    private String description;
    private double price;

}
