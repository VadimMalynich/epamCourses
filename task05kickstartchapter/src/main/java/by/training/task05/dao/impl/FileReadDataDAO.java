package by.training.task05.dao.impl;

import by.training.task05.dao.DAOException;
import by.training.task05.dao.ReadDataDAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadDataDAO implements ReadDataDAO {
    @Override
    public List<String> readData(File file) throws DAOException {
        List<String> lines;
        try (Stream<String> lineStream = Files.lines(Path.of(file.getPath()))) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
        return lines;
    }
}
