package it.gestionewebuni.system;
@RestController
@RequestMapping("/api/v1/system")
class SystemController {

    private final String version;

    SystemController(@value("${app.version}") String version) {
        this.version = version;
    }

    @GetMapping("/info")
    SystemInfo info() {
        return new SystemInfo("gestionewebuni", version, Instant.now());
    }

    record SystemInfo(String name, String version, Instant serverTime) {}
}
