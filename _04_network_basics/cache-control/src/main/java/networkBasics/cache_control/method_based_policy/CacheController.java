package networkBasics.cache_control.method_based_policy;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class CacheController {

    @GetMapping(value = "/max-age")
    public ResponseEntity<String> maxAge() {
        double temp = (Math.random() * 20) + 50;
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.SECONDS))
                .body("Current value: " + temp);
    }

    @GetMapping(value = "/public_max-age_stale-while-revalidate")
    public ResponseEntity<String> publicMaxAgeStaleWhileRevalidate() {
        return ResponseEntity.ok()
                .cacheControl(
                        CacheControl.maxAge(3600, TimeUnit.SECONDS)
                                .cachePublic()
                                .staleWhileRevalidate(300, TimeUnit.SECONDS))
                .body("Caching policy is public, max-age=3600, stale-while-revalidate=300");
    }

    @GetMapping(value = "/private_no-cache_no-store")
    public ResponseEntity<String> privateNoCacheNoStore() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noStore().cachePrivate())
                .body("Private no-cache no-store method.");
    }


}
