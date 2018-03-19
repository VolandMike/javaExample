package net.thumbtack.school.ttschool;

import java.util.*;

public class School {
    private Set<Group> groups;
    private String name;
    private int year;

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        groups = new HashSet<Group>();

    }

    public Set<Group> getGroups() {
        return groups;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    /**
     * Добавляет Group в школу. Если группа с таким именем уже есть,
     * выбрасывает TrainingException с  TrainingErrorCode.DUPLICATE_GROUP_NAME
     *
     * @param group
     */
    public void addGroup(Group group) throws TrainingException {
        for (Group i : getGroups()) {
            if (i.getName().equals(group.getName()))
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        getGroups().add(group);


    }

    /**
     * Удаляет Group из школы. Если такой Group в школе нет,
     * выбрасывает TrainingException с TrainingErrorCode.GROUP_NOT_FOUND
     *
     * @param group
     */
    public void removeGroup(Group group) throws TrainingException {

        if (!getGroups().remove(group))
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);

    }

    /**
     * Удаляет Group с данным названием из школы.
     * Если группа с таким названием не найдена,
     * выбрасывает TrainingException с TrainingErrorCode.GROUP_NOT_FOUND
     *
     * @param name
     */
    public void removeGroup(String name) throws TrainingException {

        for (Group g : getGroups()) {
            if (g.getName().equals(name)) {
                removeGroup(g);
                //т.к. такой один, и размер коллекции стал меньше
                return;
            }
        }
        throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    /**
     * Определяет, есть ли в школе группа с таким названием.
     *
     * @param group
     * @return
     */
    public boolean containsGroup(Group group) {
        return getGroups().contains(group);
    }


}
