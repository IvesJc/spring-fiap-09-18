package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

    Optional<Aluno> findAlunoByApelido(String apelido);
    List<Aluno> findAllAlunoByMateriaPreferida(String materiaPreferida);
    List<Aluno> findAlunosByMateriaPreferidaAndApelido(String materiaPreferida, String Apelido);

    List<Aluno> findAlunoByDataDaMatriculaGreaterThanEqual(LocalDate date);
    //                                    After

    @Query("SELECT * FROM ALUNO WHERE apelido LIKE args[0]")
    List<Aluno> findAlunoByQuery(String apelido);

}
