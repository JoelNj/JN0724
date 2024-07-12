package com.programmingdemojn0724.jn0724.data;

import com.programmingdemojn0724.jn0724.domain.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool,Long> {
    Tool findByToolCode(String toolCode);
}
