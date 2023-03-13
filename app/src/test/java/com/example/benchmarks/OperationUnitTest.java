package com.example.benchmarks;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import com.example.benchmarks.domain.operation.Operation;
import com.example.benchmarks.domain.operation.OperationType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;

public class OperationUnitTest {
    private List<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
    }

    @Test
    public void testExecute_AddStart() {
        Operation operation = new Operation(list, OperationType.ADD_START);
        operation.execute();
        assertEquals((int) list.get(0), 0);
    }

    @Test
    public void testExecute_AddMiddle() {
        Operation operation = new Operation(list, OperationType.ADD_MIDDLE);
        operation.execute();
        assertEquals((int) list.get(5), 0);
    }

    @Test
    public void testExecute_AddEnd() {
        Operation operation = new Operation(list, OperationType.ADD_END);
        operation.execute();
        assertEquals((int) list.get(list.size() - 1), 0);
    }

    @Test
    public void testExecute_RemoveStart() {
        Operation operation = new Operation(list, OperationType.REMOVE_START);
        operation.execute();
        assertEquals((int) list.get(0), 0);
    }

    @Test
    public void testExecute_RemoveMiddle() {
        Operation operation = new Operation(list, OperationType.REMOVE_MIDDLE);
        operation.execute();
        assertEquals((int) list.get(4), 0);
    }

    @Test
    public void testExecute_RemoveEnd() {
        Operation operation = new Operation(list, OperationType.REMOVE_END);
        operation.execute();
        assertEquals((int) list.get(list.size() - 1), 0);
    }

    @Test
    public void testExecute_Search() {
        Operation operation = new Operation(list, OperationType.SEARCH);
        operation.execute();
        assertEquals(list.contains(0), true);
    }

    @Test
    public void testExecuteAndReturnUptime() {
        List<Integer> list = new ArrayList<>();
        Operation operation = new Operation(list, OperationType.ADD_START);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void executeAndReturnUptime_returnsExecutionTime() {
        List<Integer> list = new LinkedList<>();
        Operation operation = new Operation(list, OperationType.ADD_START);

        Observable<Integer> observable = operation.executeAndReturnUptime();

        TestObserver<Integer> observer = new TestObserver<>();
        observable.subscribe(observer);
        observer.assertComplete();
        observer.assertNoErrors();

        long executionTime = System.currentTimeMillis() - observer.values().get(0);

        assertTrue(executionTime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_AddStart() {
        List<Integer> list = new ArrayList<>();
        Operation operation = new Operation(list, OperationType.ADD_START);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_AddMiddle() {
        List<Integer> list = new ArrayList<>();
        Operation operation = new Operation(list, OperationType.ADD_MIDDLE);


        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_AddEnd() {
        List<Integer> list = new ArrayList<>();
        Operation operation = new Operation(list, OperationType.ADD_END);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_RemoveStart() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Operation operation = new Operation(list, OperationType.REMOVE_START);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_RemoveMiddle() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Operation operation = new Operation(list, OperationType.REMOVE_MIDDLE);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_RemoveEnd() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Operation operation = new Operation(list, OperationType.REMOVE_END);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_Search() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Operation operation = new Operation(list, OperationType.SEARCH);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }
}
