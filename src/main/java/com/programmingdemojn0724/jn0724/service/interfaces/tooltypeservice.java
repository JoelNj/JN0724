package com.programmingdemojn0724.jn0724.service.interfaces;

import com.programmingdemojn0724.jn0724.domain.ToolType;

import java.util.List;

public interface tooltypeservice {

    public ToolType save(ToolType toolType);
    public List<ToolType> findAll();
    public ToolType getOne(Long id);
}
