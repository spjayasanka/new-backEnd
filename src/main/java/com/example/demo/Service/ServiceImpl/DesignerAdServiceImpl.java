package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.DesignerAd;
import com.example.demo.Repository.DesignerAdRepo;
import com.example.demo.Service.DesignerAdService;
import com.example.demo.dto.DesignerAdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DesignerAdServiceImpl implements DesignerAdService {

    @Autowired
    private DesignerAdRepo designerAdRepo;

    @Override
    public void saveDesignerAd(DesignerAdDTO dto) {
        DesignerAd designerAd = new DesignerAd();
        designerAd.setAdTitle(dto.getAdTitle());
        designerAd.setCategory(dto.getCategory());
        designerAd.setPrice(dto.getPrice());
        designerAd.setRating(dto.getRating());
        designerAd.setDescription(dto.getDescription());

        designerAdRepo.save(designerAd);
    }


    @Override
    public List<DesignerAd> getAllDesignerAd() {
        return (List<DesignerAd>) designerAdRepo.findAll();
    }

}
