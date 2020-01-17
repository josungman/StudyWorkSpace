package chapter15.hashset;

public class Person {

		private int id;
		private String name;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Person(int id, String name) {
			
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return this.id + ":" + this.name;
		}
		
		@Override
		public int hashCode() {
			return this.id == o.id && this.name.hashCode(o.setName(name));
		
		}
		
		@Override
		public boolean equals(Object obj) {
			Person o = (Person) obj;
			return this.id == o.id && this.name.equals(o.setName(name));
		}

}
