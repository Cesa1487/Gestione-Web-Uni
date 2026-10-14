package it.gestionewebuni.backend.system;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import java.time.Instant;

@RestController
@RequestMapping("/api/v1/system")
class SystemController {

    private final String version;

    SystemController(@Value("${app.version}") String version) {
        this.version = version;
    }

    @GetMapping("/info")
    SystemInfo info() {
        return new SystemInfo("gestionewebuni", version, Instant.now());
    }

    record SystemInfo(String name, String version, Instant serverTime) {}
}
 