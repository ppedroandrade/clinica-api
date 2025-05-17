package aspect;

import model.BaseEntity;
import service.audit.AuditService;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditService auditService;

    @AfterReturning(pointcut = "execution(* repository.*.save(..))", returning = "result")
    @Transactional
    public void logInsert(Object result) {
        if (result instanceof BaseEntity entity) {
            auditService.log("INSERT", entity.getCreatedBy(), entity.getClass().getSimpleName(), entity.getId());
        }
    }

    @AfterReturning(pointcut = "execution(* repository.*.delete(..))", returning = "result")
    @Transactional
    public void logDelete(Object result) {
        if (result instanceof BaseEntity entity) {
            auditService.log("DELETE", entity.getCreatedBy(), entity.getClass().getSimpleName(), entity.getId());
        }
    }
}