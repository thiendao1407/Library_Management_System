- Auto-return connection to pool when calling close() method

		@Override
		public void close() throws SQLException {
			isClosed = true;
			DataSource.returnConnection(this);
		}

- Remove validate() method from 'ConnectionPool'
- Change the visibility of returnConnection() method of 'DataSource' to default. Now we can only use this method indirectly outside the 'connectionpool' package by calling close () method
- Update returnConnectionToPool() method, each time calling this method, we still remain the real connection but create a new MyConnection object to hold it.
