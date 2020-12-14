package by.gsu.pms.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Triangle {

    private Integer id;

    private List<Point> angleList = new ArrayList<>();
}
