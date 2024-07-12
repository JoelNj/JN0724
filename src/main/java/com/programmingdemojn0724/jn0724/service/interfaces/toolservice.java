package com.programmingdemojn0724.jn0724.service.interfaces;

import com.programmingdemojn0724.jn0724.domain.Tool;

import java.util.List;

public interface toolservice {
    public Tool save(Tool tool);

    public Tool getOne(String toolCode);

    public List<Tool> getAll();
}
