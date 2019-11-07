package com.turkcell.training.rxjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class EmployeeParser {
	public static void main(String[] args) throws Exception {
		PublishSubject<String> employeeSubject = PublishSubject.<String>create();

		employeeSubject.filter(p -> {
			System.out.println("FILTER 0 " + p);

			return p.length() > 10;
		}).subscribe(s -> System.out.println(s));

		Observable<Employee> filter = employeeSubject.map(str -> {
			String[] split = str.split(",");
			if (split.length == 3) {
				return new Employee(split[0], split[1], split[2]);
			}
			return new Employee();
		}).filter(e -> {
			System.out.println("FILTER 1 " + e);
			return e.getName() != null;
		}).filter(e -> {
			System.out.println("FILTER 2 " + e);
			return e.getPhone().length() > 3;
		});

		Observable<Employee> doAfterNext = filter.filter(e -> {
			System.out.println("FILTER 3 " + e);
			return e.getPhone().length() > 7;
		}).doAfterNext(a -> System.out.println("DO NEXT TEST : " + a));
		doAfterNext.subscribe(s -> System.out.println("NEW EMPL " + s));

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);

		filter.observeOn(Schedulers.from(newFixedThreadPool)).subscribe(e -> {
			System.out.println("SUBS 1 - Thread " + Thread.currentThread().getName() +  " " +  e);
		});

		filter.subscribe(e -> {
			System.out.println("SUBS 2 - Thread " + Thread.currentThread().getName() +  " " +  e);
		});

		filter.subscribe(e -> {
			System.out.println("SUBS 3 - Thread " + Thread.currentThread().getName() +  " " +  e);
		});

		List<String> readAllLines = Files.readAllLines(Paths.get("employee.txt"));
		readAllLines.stream().forEach(l -> employeeSubject.onNext(l));

	}
}
