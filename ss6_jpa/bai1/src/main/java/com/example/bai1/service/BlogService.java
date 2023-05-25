package com.example.bai1.service;

import com.example.bai1.model.BlogModel;
import com.example.bai1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<BlogModel> findAll() {
        return iBlogRepository.findAll();
    }
@Transactional
    @Override
    public void save(BlogModel blogModel) {
        iBlogRepository.save(blogModel);

}

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public BlogModel findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }
}
