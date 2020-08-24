package basic.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {
	
	//  pie 차트 만들기 학습
	
	@Override
	public void start(Stage primaryStage) {
		PieChart pc = new PieChart();
		
		
		ObservableList<PieChart.Data> pieList = 
				FXCollections.observableArrayList(
						new PieChart.Data("사과", 100),
						new PieChart.Data("복숭아", 50),
						new PieChart.Data("딸기", 20),
						new PieChart.Data("오렌지", 80),
						new PieChart.Data("포도", 15)
						
						);
		// pie차트에 데이터 리스트 넣기
		pc.setData(pieList);
		
		// 차트 제목 설정
		pc.setTitle("과일별 재고량");
		
		Scene scene = new Scene(pc);
		primaryStage.setScene(scene);
		primaryStage.setTitle("원 그래프 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
