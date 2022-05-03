package dev.sectorsone;

import dev.sectorsone.model.Involvement;
import dev.sectorsone.service.InvolvementService;
import dev.sectorsone.service.SectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SectorsOneApplicationTests {
    @Autowired
    SectorService sectorService;
    @Autowired
    InvolvementService involvementService;

    @Test
    void sectorDataInitTest() {
        var sectors = sectorService.findAll();
        assertEquals(79, sectors.size());
    }

    @Test
    void addInvolvementTest() {
        var involvement = new Involvement();
        involvement.setName("Ann Õun");
        involvement.setAgreeToTerms(true);
        var sectorList = List.of(sectorService.findAll().get(0));
        involvement.setSectorList(sectorList);
        var savedInvolvement = involvementService.save(involvement);
        assertNotNull(savedInvolvement.getId());
        assertEquals("Ann Õun", savedInvolvement.getName());
        assertTrue(savedInvolvement.getAgreeToTerms());
        assertEquals("Manufacturing", savedInvolvement.getSectorList().get(0).getName());
    }
}
