package dev.joaobertholino.udemyspringwithmongo.repository;

import dev.joaobertholino.udemyspringwithmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
