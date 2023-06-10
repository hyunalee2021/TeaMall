package teamall.domain;

import java.util.*;
import lombok.*;
import teamall.domain.*;
import teamall.infra.AbstractEvent;

@Data
@ToString
public class DeliverCompleted extends AbstractEvent {

    private Long id;
}
