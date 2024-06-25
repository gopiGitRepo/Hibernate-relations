package com.raven.springbootonetoonemapping.entiry;

import javax.persistence.*;

@Entity
@Table(name = "ENGINE")
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "engine_type")
	private String engineType = "";

	@Column(name = "capacity")
	private String capacity = "";

	@Column(name = "max_torque")
	private String maxTorque = "";

	@OneToOne(mappedBy = "engine",cascade = CascadeType.ALL)
	private Motorcycle motorCycle = null;

	public Engine() {
	}

	public Engine(String engineType, String capacity, String maxTorque) {
		this.engineType = engineType;
		this.capacity = capacity;
		this.maxTorque = maxTorque;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getMaxTorque() {
		return maxTorque;
	}

	public void setMaxTorque(String maxTorque) {
		this.maxTorque = maxTorque;
	}

	public Motorcycle getMotorCycle() {
		return motorCycle;
	}

	public void setMotorCycle(Motorcycle motorCycle) {
		this.motorCycle = motorCycle;
	}

	@Override
	public String toString() {
		return "Engine{" + "Id=" + Id + ", engineType='" + engineType + '\'' + ", capacity='" + capacity + '\''
				+ ", maxTorque='" + maxTorque + '\'' + '}';
	}
}
