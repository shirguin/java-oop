package Lesson_5.Class_Work;

import java.util.List;

public class RepositoryLinks implements Repository<Link, Long> {
    @Override
    public Long save(Link link) {
        List<LinkData> linkTable = DataBase.getLinksTable();
        linkTable.add(new LinkData(link));
        return LinkData.getId();
    }

    @Override
    public Link findByID(Long aLong) {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {

    }
}