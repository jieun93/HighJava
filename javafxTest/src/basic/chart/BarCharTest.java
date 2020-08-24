package basic.chart;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarCharTest extends Application {
	
	// BarCharTest 를 이용해서 축이 있는 그래프를 어떻게 셋팅하는지 학습
	
	@Override
	public void start(Stage primaryStage) {
		
		// x축을 담당하는 객체 생성
		CategoryAxis xAxis = new CategoryAxis();
		
		// y축을 담당하는 객체 생성
		NumberAxis yAxis = new NumberAxis();
		
		// x축, y축을 담당하는 객체를 매개값으로 BarChart객체 생성
		
		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		
		bc.setTitle("나라별 Data"); // 축의 제목
		xAxis.setLabel("나라이름 "); // X 축의  제목
		yAxis.setLabel("Value"); // y 축의 제목 
		
		
		// Chart에 출력할 데이터 구성하기
		
		// 1. series 객체 생성    ( series는 막대 그래프 같은 데이터)
		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ser1.setName("2018년 "); // series 이름 설정 
		
		// 2. 데이터 설정 1
		ser1.getData().add(new XYChart.Data<String, Number>("호주",12000));
		ser1.getData().add(new XYChart.Data<String, Number>("영국",10000));
		ser1.getData().add(new XYChart.Data<String, Number>("미국",13000));
		ser1.getData().add(new XYChart.Data<String, Number>("한국",18000));
		ser1.getData().add(new XYChart.Data<String, Number>("중국 ",9000));
		//-------------------------------------------------------------------------------
		
		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
		ser2.setName("2019년");
		
		
		
		// 데이터 설정의 또 다른 방법 2 ==> ObservableList 객체 이용하기 
		ObservableList<XYChart.Data<String, Number>> ser2List =
				FXCollections.observableArrayList();
		
		ser2List.addAll(
				new XYChart.Data<>("호주",8000),
				new XYChart.Data<>("영국",1800),
				new XYChart.Data<>("미국",2800),
				new XYChart.Data<>("한국",15000),
				new XYChart.Data<>("중국",11000)
				
				);
		// 데이터를 리스트에 담아서 넣어주는 거 
		ser2.setData(ser2List);
		
		// 방법 3
		
		XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
		ser3.setName("2020년");
		
		ser3.getData().add(new XYChart.Data<>("호주",10000));
		ser3.getData().add(new XYChart.Data<>("영국",21000));
		ser3.getData().add(new XYChart.Data<>("미국",16000));
		ser3.getData().add(new XYChart.Data<>("한국",19000));
		ser3.getData().add(new XYChart.Data<>("중국",12000));
		
		// 3. series객체를 chart 에 추가한다.
		bc.getData().addAll(ser1, ser2, ser3);
		
		bc.setBarGap(10);		// 막대 그래프 사이의 간격 조정 
		bc.setCategoryGap(30); // 카테고리 사의 간격 조정
		
		Scene scene = new Scene(bc);
		primaryStage.setScene(scene);
		primaryStage.setTitle("막대그래프 연습");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
