package teamall.domain;

import java.util.*;
import lombok.*;
import teamall.domain.*;
import teamall.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
}
