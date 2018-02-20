package fr.project.restservice.services;

import fr.project.restservice.entities.Sample;
import fr.project.restservice.repositories.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:52
 */
@Service
public class SampleService {

    @Autowired
    private final SampleRepo sampleRepo;

    @Autowired
    public SampleService(SampleRepo sampleRepo) {
        this.sampleRepo = sampleRepo;
    }

    public List<Sample> getAllSample(){
        List<Sample> sampleList= (List<Sample>) sampleRepo.findAll();
        return sampleList;
    }
}
