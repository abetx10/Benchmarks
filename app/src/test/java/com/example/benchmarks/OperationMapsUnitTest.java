package com.example.benchmarks;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.example.benchmarks.domain.operation.OperationMaps;
import com.example.benchmarks.domain.operation.OperationTypeMaps;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;

public class OperationMapsUnitTest {
    HashMap map = new HashMap<>();

    @Before
    public void setUp() {
        map = new HashMap<>();
    }

    @Test
    public void testExecute_AddNew() {
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.ADD_NEW);
        operation.execute();
        assertEquals(map.get(100000), "default");
    }

    @Test
    public void testExecute_Search() {
        map.put(100000, "default");
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.SEARCH);
        operation.execute();
        assertEquals(map.get(100000), "default");
    }

    @Test
    public void testExecute_Remove() {
        map.put(100000, "default");
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.REMOVE);
        operation.execute();
        assertEquals(map.containsKey(100000), false);
    }

    @Test
    public void testExecuteAndReturnUptime() {
        Map<Integer, String> map = new HashMap<>();
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.ADD_NEW);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void executeAndReturnUptime_returnsExecutionTime() {
        Map<Integer, String> map = new HashMap<>();
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.ADD_NEW);

        Observable<Integer> observable = operation.executeAndReturnUptime();

        TestObserver<Integer> observer = new TestObserver<>();
        observable.subscribe(observer);
        observer.assertComplete();
        observer.assertNoErrors();

        long executionTime = System.currentTimeMillis() - observer.values().get(0);

        assertTrue(executionTime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_AddNew() {
        Map<Integer, String> map = new HashMap<>();
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.ADD_NEW);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_Search() {
        Map<Integer, String> map = new HashMap<>();
        map.put(100000, "default");
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.SEARCH);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }

    @Test
    public void testExecuteAndReturnUptime_Remove() {
        Map<Integer, String> map = new HashMap<>();
        map.put(100000, "default");
        OperationMaps operation = new OperationMaps(map, OperationTypeMaps.REMOVE);

        int uptime = operation.executeAndReturnUptime().blockingFirst();

        assertTrue(uptime >= 0);
    }
}