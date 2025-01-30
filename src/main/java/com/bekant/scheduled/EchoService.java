package com.bekant.scheduled;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EchoService {

    private Clock clock;

    @Scheduled(fixedDelay = 15000)
    public void scheduleEcht() {

       LocalDateTime localDateTime = LocalDateTime.now(clock);

       // LocalDateTime utc = localDateTime.atZone(ZoneId.of("UTC"));
       ZonedDateTime ldtZoned = localDateTime.atZone(clock.getZone());
       ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
       log.info("## hey hey at {}", utcZoned);
    }

}
