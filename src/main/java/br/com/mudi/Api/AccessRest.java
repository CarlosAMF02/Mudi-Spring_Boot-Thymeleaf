package br.com.mudi.Api;

import br.com.mudi.Interceptor.AccessInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/access")
public class AccessRest {

    @GetMapping()
    public List<AccessInterceptor.Access> getAccesses() {
        return AccessInterceptor.accesses;

    }
}
