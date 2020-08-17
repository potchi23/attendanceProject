package view.mainFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controller.Controller;
import utils.JSONManager;
import view.addMember.AddNewMemberWindow;
import view.closeWindow.EndExe;
import view.meetings.CreatePage;
import view.notifications.MessageWindow;
import view.preferences.ConnectionSettings;
import view.toolBar.Info;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Component;

public class MainWindow {

	private JFrame frmAttendanceManager;
	private Controller _ctrl;
	private JButton connectButton;
	private String client;
	private String host;
	private String port;
	private String sid;
	private String username;
	private String password;
	private MainWindow _this = this;
	private JLabel botInfo =  new JLabel("Disconnected");
	/**
	 * Create the application.
	 */
	public MainWindow(Controller ctrl) {
		JSONManager json = new JSONManager();
		String[] info = json.getFile();
		
		client = info[0];
		host = info[1];
		port = info[2];
		sid = info[3];
		username = info[4];
		password = info[5];
		initialize();
		_ctrl = ctrl;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAttendanceManager = new JFrame();
		frmAttendanceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAttendanceManager.setResizable(false);
		frmAttendanceManager.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/resources/icons/contract.png")));
		frmAttendanceManager.setTitle("Attendance Manager");
		frmAttendanceManager.setFont(new Font("Arial", Font.PLAIN, 12));
		frmAttendanceManager.setBounds(100, 100, 243, 319);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frmAttendanceManager.setJMenuBar(menuBar);
		
		JMenu mnPreferences = new JMenu("Preferences");
		mnPreferences.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnPreferences);
		
		JMenuItem mntmSetConnetion = new JMenuItem("Set connetion");
		mntmSetConnetion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ConnectionSettings frame = new ConnectionSettings(_this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mntmSetConnetion.setFont(new Font("Arial", Font.PLAIN, 12));
		mnPreferences.add(mntmSetConnetion);
		
		JMenuItem mntmCreateTables = new JMenuItem("Create tables");
		mntmCreateTables.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmCreateTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					_ctrl.executeQueryFromOutputFile("create");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Tables created.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (IOException e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Creation tables doesn't exist.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (SQLException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Tables are already created.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (NullPointerException e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Database is disconnected.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} 
			}
		});
		mnPreferences.add(mntmCreateTables);
		
		JMenuItem mntmdebugDropTables = new JMenuItem("[DEBUG] Drop tables");
		mntmdebugDropTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					_ctrl.executeQueryFromOutputFile("drop");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Tables dropped.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Drop tables doesn't exist.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (SQLException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("There are no tables to drop.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (NullPointerException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Database is disconnected.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			}
		});
		
		JMenuItem mntmdebugInsertExamples = new JMenuItem("[DEBUG] Insert examples");
		mntmdebugInsertExamples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					_ctrl.executeQueryFromOutputFile("insert");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Data inserted.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Insert tables doesn't exist.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (SQLException e) {
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("There are no tables.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (NullPointerException e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Database is disconnected.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		mntmdebugInsertExamples.setFont(new Font("Arial", Font.PLAIN, 12));
		mnPreferences.add(mntmdebugInsertExamples);
		mntmdebugDropTables.setFont(new Font("Arial", Font.PLAIN, 12));
		mnPreferences.add(mntmdebugDropTables);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Arial", Font.PLAIN, 12));
		mnAbout.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnAbout);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Info frame = new Info();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnAbout.add(mntmInfo);
		frmAttendanceManager.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel TOP = new JPanel();
		frmAttendanceManager.getContentPane().add(TOP, BorderLayout.NORTH);
		
		JPanel conButLayout = new JPanel();
		TOP.add(conButLayout);
		
		JPanel conLayout = new JPanel();
		TOP.add(conLayout);
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		conLayout.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		
		JLabel status = new JLabel("Disconnected");
		status.setHorizontalAlignment(SwingConstants.RIGHT);
		conLayout.add(status);
		status.setFont(new Font("Arial", Font.BOLD, 10));
		status.setForeground(Color.RED);
		
		JPanel MAIN = new JPanel();
		frmAttendanceManager.getContentPane().add(MAIN, BorderLayout.CENTER);
		MAIN.setLayout(new BoxLayout(MAIN, BoxLayout.Y_AXIS));
		
		JPanel buttonsPanel = new JPanel();
		MAIN.add(buttonsPanel);
		buttonsPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		buttonsPanel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton createButton = new JButton("Create attendance page");
		createButton.setEnabled(false);
		panel_2.add(createButton);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreatePage frame = new CreatePage(_ctrl);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MessageWindow frame = new MessageWindow("Tables are not created.");
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					}
				});
			}
		});
		createButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton insertButton = new JButton("Insert new member");
		insertButton.setEnabled(false);
		panel_2.add(insertButton);
		insertButton.setPreferredSize(createButton.getPreferredSize());
		
		insertButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddNewMemberWindow frame = new AddNewMemberWindow(_ctrl);
							frame.setVisible(true);
						} catch (Exception e) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MessageWindow frame = new MessageWindow("Tables are not created.");
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
					}
				});
			}
		});
		insertButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JPanel closePanel = new JPanel();
		MAIN.add(closePanel);
		closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		closePanel.add(panel_3);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		closePanel.add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EndExe frame = new EndExe();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		closeButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JPanel panel_5 = new JPanel();
		closePanel.add(panel_5);
		conButLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		connectButton = new JButton("CONNECT");
		connectButton.setFont(new Font("Arial", Font.BOLD, 11));
		conButLayout.add(connectButton);
		
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					_ctrl.connect(client, host, port, sid, username, password);
					status.setText("Connected");
					status.setFont(new Font("Arial", Font.BOLD, 10));
					status.setForeground(Color.GREEN);
					insertButton.setEnabled(true);
					createButton.setEnabled(true);
					botInfo.setText(client + ":" + host + ":" + port + ":" + sid);
				} catch (ClassNotFoundException e) {
					status.setText("Disconnected");
					status.setFont(new Font("Arial", Font.BOLD, 10));
					status.setForeground(Color.RED);
					insertButton.setEnabled(false);
					createButton.setEnabled(false);
					botInfo.setText("No connection");
					e.printStackTrace();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Driver not found.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				} catch(NullPointerException | SQLException e) {
					status.setText("Disconnected");
					status.setFont(new Font("Arial", Font.BOLD, 10));
					status.setForeground(Color.RED);
					insertButton.setEnabled(false);
					createButton.setEnabled(false);
					e.printStackTrace();
					botInfo.setText("No connection");
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MessageWindow frame = new MessageWindow("Database not found.");
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		
//		JButton disconnectButton = new JButton("DISCONNECT");
//		disconnectButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					_ctrl.disconnect();
//					status.setText("Disconnected");
//					status.setForeground(Color.RED);
//					createButton.setEnabled(false);
//					insertButton.setEnabled(false);
//					botInfo.setText("No connection");
//					
//				} catch (SQLException | NullPointerException e) {
//					EventQueue.invokeLater(new Runnable() {
//						public void run() {
//							try {
//								MessageWindow frame = new MessageWindow("The database is already disconnected.");
//								frame.setVisible(true);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					});
//				}
//			}
//		});
//		disconnectButton.setFont(new Font("Arial", Font.BOLD, 11));
//		GridBagConstraints gbc_disconnectButton = new GridBagConstraints();
//		gbc_disconnectButton.anchor = GridBagConstraints.WEST;
//		gbc_disconnectButton.gridx = 0;
//		gbc_disconnectButton.gridy = 1;
//		conButLayout.add(disconnectButton, gbc_disconnectButton);
		
		JPanel BOT = new JPanel();
		frmAttendanceManager.getContentPane().add(BOT, BorderLayout.SOUTH);
		BOT.setLayout(new BoxLayout(BOT, BoxLayout.X_AXIS));
		
		
		botInfo = new JLabel("No connection");
		BOT.add(botInfo);
		botInfo.setHorizontalAlignment(SwingConstants.LEFT);
		botInfo.setFont(new Font("Arial", Font.PLAIN, 9));
	}
	
	public void setConnectionURL(String client, String host, String port, String sid, String username, String password) {
		this.client = client;
		this.host = host;
		this.port = port;
		this.sid = sid;
		this.username = username;
		this.password = password;
	}
	
	public JFrame getFrame() {
		return frmAttendanceManager;
	}
}
