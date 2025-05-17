package service.audit;

import model.audit.Audit;
import repository.audit.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public void log(String action, Long userId, String entity, Long entityId) {
        Audit audit = new Audit(action, userId, entity, entityId);
        auditRepository.save(audit);
    }
}