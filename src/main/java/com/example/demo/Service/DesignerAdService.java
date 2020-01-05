package com.example.demo.Service;

import com.example.demo.Entity.DesignerAd;
import com.example.demo.dto.DesignerAdDTO;
import java.util.List;

public interface DesignerAdService {

    void saveDesignerAd(DesignerAdDTO dto);
    List<DesignerAd> getAllDesignerAd();
}
